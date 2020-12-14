use anyhow::Result;
use day4::{count_valid_passports, validate_passport1};

pub fn main() -> Result<()> {
    println!("{}", count_valid_passports(validate_passport1)?);
    Ok(())
}
