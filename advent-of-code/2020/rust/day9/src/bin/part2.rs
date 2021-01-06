use anyhow::Result;
use itertools::Itertools;

use day9::{find_not_sum, parse_numbers};

fn main() -> Result<()> {
    let numbers = parse_numbers()?;
    println!("{}", find_contiguity(&numbers, find_not_sum(&numbers)));
    Ok(())
}

fn find_contiguity(numbers: &[u64], value: u64) -> u64 {
    for (i, mut sum) in numbers.iter().copied().enumerate() {
        let mut end = i;

        while sum < value && end < numbers.len() {
            end += 1;
            sum += numbers[end];
        }

        if sum == value {
            let (min, max) = numbers
                .iter()
                .copied()
                .skip(i)
                .take(end - i)
                .minmax()
                .into_option()
                .unwrap();
            return min + max;
        }
    }

    0
}
