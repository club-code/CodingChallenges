use anyhow::Result;
use day8::{parse_instructions, Evaluator};

/// Solves part 1 by parsing the instructions and running them until a loop is found.
fn main() -> Result<()> {
    println!(
        "{}",
        Evaluator::new(&mut parse_instructions()?)
            .eval_until_loop()
            .1
    );
    Ok(())
}
