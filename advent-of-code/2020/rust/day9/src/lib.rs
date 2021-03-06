use std::io::{self, BufRead};
use anyhow::Result;

/// The length of the """encryption""" preamble.
pub const PREAMBLE_SIZE: usize = 25;

/// Parses all the numbers from the standard input at once.
pub fn parse_numbers() -> Result<Vec<u64>> {
    io::stdin()
        .lock()
        .lines()
        .try_fold(Vec::new(), |mut numbers, line| {
            numbers.push(line?.parse()?);
            Ok(numbers)
        })
}

/// Returns the first number not a sum of two from the preamble.
pub fn find_not_sum(numbers: &[u64]) -> u64 {
    numbers
        .windows(PREAMBLE_SIZE)
        .zip(numbers.iter().copied().skip(PREAMBLE_SIZE))
        .find(|&(preamble, number)| !find_sum(preamble, number))
        .map(|(_, num)| num)
        .unwrap()
}

/// Tests whether two numbers exist in `buf` summing to `target`.
fn find_sum(buf: &[u64], target: u64) -> bool {
    buf.iter().any(|&n| buf.contains(&target.saturating_sub(n)))
}
