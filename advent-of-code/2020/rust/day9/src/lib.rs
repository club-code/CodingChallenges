use std::io::{self, BufRead};
use anyhow::Result;

pub const PREAMBLE_SIZE: usize = 25;

pub fn parse_numbers() -> Result<Vec<u64>> {
    io::stdin()
        .lock()
        .lines()
        .try_fold(Vec::new(), |mut numbers, line| {
            numbers.push(line?.parse()?);
            Ok(numbers)
        })
}

pub fn find_not_sum(numbers: &[u64]) -> u64 {
    numbers
        .windows(PREAMBLE_SIZE)
        .zip(numbers.iter().copied().skip(PREAMBLE_SIZE))
        .find(|&(preamble, number)| !find_sum(preamble, number))
        .map(|(_, num)| num)
        .unwrap()
}

fn find_sum(buf: &[u64], target: u64) -> bool {
    buf.iter().any(|&n| buf.contains(&target.saturating_sub(n)))
}
