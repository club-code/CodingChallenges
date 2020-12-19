use anyhow::Result;
use std::io::{self, BufRead};

/// Parses each line of the standard input stream into a vector of integers.
///
/// Uses `anyhow` in order to convert error types for the caller.
pub fn parse_numbers() -> Result<Vec<u32>> {
    let mut lines = Vec::new();

    for line in io::stdin().lock().lines() {
        lines.push(line?.trim_end().parse()?);
    }

    Ok(lines)
}
