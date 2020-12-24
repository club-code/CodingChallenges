use std::collections::VecDeque;
use std::io::{self, BufRead};

use anyhow::Result;
use day9::parse_preamble;

fn main() -> Result<()> {
    let mut preamble = parse_preamble()?;

    for line in io::stdin().lock().lines() {
        let number = line?.parse()?;

        if !find_sum(&preamble, number) {
            println!("{}", number);
            break;
        } else {
            preamble.pop_front();
            preamble.push_back(number);
        }
    }

    Ok(())
}

fn find_sum(buf: &VecDeque<u64>, target: u64) -> bool {
    buf.iter().any(|&n| buf.contains(&target.saturating_sub(n)))
}
