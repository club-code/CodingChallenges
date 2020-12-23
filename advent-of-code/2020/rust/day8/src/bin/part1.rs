use anyhow::Result;
use day8::{parse_instructions, Evaluator};

fn main() -> Result<()> {
    println!(
        "{}",
        Evaluator::new(&mut parse_instructions()?)
            .take_while(|(_, _, ins, _)| ins.passes != 2)
            .map(|(old_acc, _, _, _)| old_acc)
            .last()
            .unwrap()
    );
    Ok(())
}
