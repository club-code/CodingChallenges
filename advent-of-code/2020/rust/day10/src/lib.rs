use anyhow::Result;
use std::io::{self, BufRead};

/// Parses all numbers available on the standard input stream at once.
pub fn parse_ratings() -> Result<Vec<u8>> {
    io::stdin()
        .lock()
        .lines()
        .try_fold(Vec::new(), |mut nums, line| {
            nums.push(line?.parse()?);
            Ok(nums)
        })
}
