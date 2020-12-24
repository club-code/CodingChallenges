use std::collections::VecDeque;
use std::io::{self, BufRead};

use anyhow::Result;

pub const PREAMBLE_SIZE: usize = 25;

pub fn parse_preamble() -> Result<VecDeque<u64>> {
    let mut preamble = VecDeque::new();

    for line in io::stdin().lock().lines().take(PREAMBLE_SIZE) {
        preamble.push_back(line?.parse()?);
    }

    Ok(preamble)
}
