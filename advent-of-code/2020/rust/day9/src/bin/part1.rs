use anyhow::Result;
use day9::{find_not_sum, parse_numbers};

fn main() -> Result<()> {
    println!("{}", find_not_sum(&parse_numbers()?));
    Ok(())
}
