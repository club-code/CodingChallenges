use anyhow::Result;
use day4::{count_valid_passports, validate_passport2};

/// Solves part 2 using in-common functions.
pub fn main() -> Result<()> {
    println!("{}", count_valid_passports(validate_passport2)?);
    Ok(())
}
