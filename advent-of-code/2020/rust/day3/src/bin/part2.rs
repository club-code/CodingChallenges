use anyhow::Result;
use day3::{mult_counts, parse_grid};

pub fn main() -> Result<()> {
    println!(
        "{}",
        mult_counts(&parse_grid()?, &[(1, 1), (1, 3), (1, 5), (1, 7), (2, 1)])
    );
    Ok(())
}
