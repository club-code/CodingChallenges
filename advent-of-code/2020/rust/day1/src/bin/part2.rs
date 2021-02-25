use anyhow::Result;
use day1::parse_numbers;
use std::collections::HashSet;

/// Searches for the triplet of numbers in the given set that sum to `target`
/// and returns their product if found, `None` otherwise.
fn find_prod(target: u32, numbers: HashSet<u32>) -> Option<u32> {
    for num in numbers.iter() {
        for other in numbers.iter() {
            if other != num && numbers.contains(&target.saturating_sub(num + other)) {
                return Some((target - num - other) * num * other);
            }
        }
    }

    None
}

/// Solves part 2 by converting the input vector into a hash set.
pub fn main() -> Result<()> {
    println!(
        "{}",
        find_prod(2020, parse_numbers()?.into_iter().collect()).unwrap()
    );
    Ok(())
}
