use anyhow::Result;
use day8::{parse_instructions, Evaluator, Instruction, Operation};

fn main() -> Result<()> {
    let inss = parse_instructions()?;

    for (pc, ins) in inss.iter().enumerate() {
        match ins.op {
            Operation::Nothing => {
                if ins.arg != 0 && print_fixed_acc(&inss, Operation::Jump, pc) {
                    break;
                }
            }
            Operation::Jump => {
                if print_fixed_acc(&inss, Operation::Nothing, pc) {
                    break;
                }
            }
            Operation::Accumulate => {}
        }
    }

    Ok(())
}

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
