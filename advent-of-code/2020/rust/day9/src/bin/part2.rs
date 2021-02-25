use anyhow::Result;
use itertools::Itertools; // For `minmax`.

use day9::{find_not_sum, parse_numbers};

/// Solves part 2 by re-using part 1 and searching for the contiguity after.
fn main() -> Result<()> {
    let numbers = parse_numbers()?;
    println!("{}", find_contiguity(&numbers, find_not_sum(&numbers)));
    Ok(())
}

/// Finds the wanted contiguity in `numbers` summing to `value` and returns
/// the sum of its extreme values.
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
