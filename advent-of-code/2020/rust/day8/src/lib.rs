use std::io::{self, BufRead};
use std::str::FromStr;

use anyhow::{bail, Error, Result};

#[derive(Debug, Clone)]
pub enum Operation {
    Accumulate,
    Jump,
    Nothing,
}

impl FromStr for Operation {
    type Err = Error;

    fn from_str(s: &str) -> Result<Self> {
        Ok(match s {
            "acc" => Self::Accumulate,
            "jmp" => Self::Jump,
            "nop" => Self::Nothing,
            _ => bail!("Unknown operation: '{}'", s),
        })
    }
}

#[derive(Debug, Clone)]
pub struct Instruction {
    pub op: Operation,
    pub arg: i16,
    pub passes: u8,
}

impl FromStr for Instruction {
    type Err = Error;

    fn from_str(s: &str) -> Result<Self> {
        let mut parts = s.split_whitespace();
        Ok(Self {
            op: parts.next().unwrap().parse()?,
            arg: parts.next().unwrap().parse()?,
            passes: 0,
        })
    }
}

pub fn parse_instructions() -> Result<Vec<Instruction>> {
    let mut ins = Vec::new();

    for line in io::stdin().lock().lines() {
        ins.push(line?.parse()?);
    }

    Ok(ins)
}

pub struct Evaluator<'a> {
    ins: &'a mut [Instruction],
    pc: usize,
    acc: i32,
}

impl<'a> Evaluator<'a> {
    pub fn new(ins: &'a mut [Instruction]) -> Self {
        Self { ins, pc: 0, acc: 0 }
    }

    pub fn eval_until_loop(&mut self) -> <Self as Iterator>::Item {
        self.take_while(|(_, _, ins)| ins.passes != 2)
            .last()
            .unwrap()
    }
}

impl<'a> Iterator for Evaluator<'a> {
    type Item = (usize, i32, Instruction);

    fn next(&mut self) -> Option<Self::Item> {
        if self.pc >= self.ins.len() {
            None
        } else {
            let ins = &mut self.ins[self.pc];
            ins.passes += 1;
            let old_ins = ins.clone();

            match ins.op {
                Operation::Accumulate => self.acc += ins.arg as i32,
                Operation::Jump => self.pc = (self.pc as isize + ins.arg as isize) as usize - 1,
                Operation::Nothing => {}
            }

            self.pc += 1;
            Some((self.pc, self.acc, old_ins))
        }
    }
}
