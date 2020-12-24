use std::io::{self, BufRead};
use std::str::FromStr;

use anyhow::{bail, Error, Result};

/// Represents a code operation: `acc`, `jmp` or `nop`.
#[derive(Debug, Clone)]
pub enum Operation {
    /// The `acc` operation.
    Accumulate,
    /// The `jmp` operation.
    Jump,
    /// The `nop` operation.
    Nothing,
}

/// Convenience implementation. Accessible through `str::parse`.
impl FromStr for Operation {
    type Err = Error;

    /// Converts the operation mnemonic into an enum value.
    fn from_str(s: &str) -> Result<Self> {
        Ok(match s {
            "acc" => Self::Accumulate,
            "jmp" => Self::Jump,
            "nop" => Self::Nothing,
            _ => bail!("Unknown operation: '{}'", s),
        })
    }
}

/// Represents a full code instruction with the number of passes.
#[derive(Debug, Clone)]
pub struct Instruction {
    /// The underlying code operation.
    pub op: Operation,
    /// The argument of the operation.
    pub arg: i16,
    /// The number of times the instruction has been executed.
    pub passes: u8,
}

/// Convenience implementation. Accessible through `str::parse`.
impl FromStr for Instruction {
    type Err = Error;

    /// Splits the line and converts it into an instruction.
    fn from_str(s: &str) -> Result<Self> {
        let mut parts = s.split_whitespace();
        Ok(Self {
            op: parts.next().unwrap().parse()?,
            arg: parts.next().unwrap().parse()?,
            passes: 0,
        })
    }
}

/// Parses all the lines from the standard input stream into instructions.
pub fn parse_instructions() -> Result<Vec<Instruction>> {
    let mut ins = Vec::new();

    for line in io::stdin().lock().lines() {
        ins.push(line?.parse()?);
    }

    Ok(ins)
}

/// Iterator executing the code with modification.
pub struct Evaluator<'a> {
    /// The code instructions, mutable for the number of passes.
    ins: &'a mut [Instruction],
    /// The "Program Counter": index of the current instruction in `ins`.
    pc: usize,
    /// The evaluation accumulator register.
    acc: i32,
}

impl<'a> Evaluator<'a> {
    /// Creates a new evaluator from a mutable slice of instructions.
    pub fn new(ins: &'a mut [Instruction]) -> Self {
        Self { ins, pc: 0, acc: 0 }
    }

    /// Runs the evaluation process until an instruction is passed twice and
    /// returns the last iteration item, i.e. the evaluation state.
    pub fn eval_until_loop(&mut self) -> <Self as Iterator>::Item {
        self.take_while(|(_, _, ins)| ins.passes != 2)
            .last()
            .unwrap()
    }
}

/// Truthfully, a tad overkill just for the above `eval_until_loop` function.
impl<'a> Iterator for Evaluator<'a> {
    /// Represents the evaluation state: the PC, the accumulator and the last
    /// executed code instruction.
    type Item = (usize, i32, Instruction);

    /// Runs the evaluation and returns the new state or `None` when out of
    /// bounds in order to stop the execution.
    fn next(&mut self) -> Option<Self::Item> {
        // Checking that here so the last instruction may be executed.
        if self.pc >= self.ins.len() {
            None
        } else {
            // Save state,
            let ins = &mut self.ins[self.pc];
            ins.passes += 1;
            let old_ins = ins.clone();

            // execute instruction,
            match ins.op {
                Operation::Accumulate => self.acc += ins.arg as i32,
                Operation::Jump => self.pc = (self.pc as isize + ins.arg as isize) as usize - 1,
                Operation::Nothing => {}
            }

            // return state.
            self.pc += 1;
            Some((self.pc, self.acc, old_ins))
        }
    }
}
