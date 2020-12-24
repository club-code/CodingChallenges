use anyhow::Result;
use day8::{parse_instructions, Evaluator};

fn main() -> Result<()> {
    println!(
        "{}",
        Evaluator::new(&mut parse_instructions()?)
            .eval_until_loop()
            .1
    );
    Ok(())
}
