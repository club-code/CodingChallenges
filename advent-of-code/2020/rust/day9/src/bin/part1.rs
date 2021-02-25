use anyhow::Result;
use day9::{find_not_sum, parse_numbers};

/// Solves part 1 by finding the desired first.
fn main() -> Result<()> {
    println!("{}", find_not_sum(&parse_numbers()?));
    Ok(())
}
