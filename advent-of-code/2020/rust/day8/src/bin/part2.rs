use anyhow::Result;
use day8::{parse_instructions, Evaluator, Instruction, Operation};

/// Solves part 2 by traversing all the instructions, inverting `nop`s and `jmp`s,
/// and checking if that fixes the code by trying executing it until a loop.
fn main() -> Result<()> {
    let inss = parse_instructions()?;

    for (pc, ins) in inss.iter().enumerate() {
        match ins.op {
            Operation::Nothing => {
                // Don't invert zero `nop`s as `jmp +0` results in a loop.
                if ins.arg != 0 && print_fixed_acc(&inss, Operation::Jump, pc) {
                    break;
                }
            }
            Operation::Jump => {
                // Finish as soon as one inversion fixes the code.
                if print_fixed_acc(&inss, Operation::Nothing, pc) {
                    break;
                }
            }
            Operation::Accumulate => {}
        }
    }

    Ok(())
}

/// Clones `inss`, assigns `op` to the instruction at index `pc` and runs the
/// evaluation. If it results in executing the program until the very last
/// instruction, then prints the accumulator and returns `true`, else `false`.
fn print_fixed_acc(inss: &[Instruction], op: Operation, pc: usize) -> bool {
    let mut fixed_inss = inss.to_vec();
    fixed_inss[pc].op = op;

    match Evaluator::new(&mut fixed_inss).eval_until_loop() {
        (final_pc, final_acc, _) if final_pc == fixed_inss.len() => {
            println!("{}", final_acc);
            true
        }
        _ => false,
    }
}
