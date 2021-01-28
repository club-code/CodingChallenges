use anyhow::Result;
use day3::{count_trees, parse_grid};

/// Solves part 1 by directly using `count_trees`.
fn main() -> Result<()> {
    println!("{}", count_trees(&parse_grid()?, (1, 3)));
    Ok(())
}
