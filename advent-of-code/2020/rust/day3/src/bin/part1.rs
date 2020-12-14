use anyhow::Result;
use day3::{count_trees, parse_grid};

fn main() -> Result<()> {
    println!("{}", count_trees(&parse_grid()?, (1, 3)));
    Ok(())
}
