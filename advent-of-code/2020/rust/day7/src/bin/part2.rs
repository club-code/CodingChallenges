use anyhow::Result;
use day7::{parse_rules, Rules, TypeCount};

/// Solves part 2 using another recursive function.
fn main() -> Result<()> {
    let rules = parse_rules()?;
    println!("{}", count_bags(&rules, &rules["shiny gold"]) - 1);
    Ok(())
}

/// Counts the number of bags directly or indirectly contained in the "shiny gold"
/// root bag. Operates recursively following the `rules` starting from `counts`.
fn count_bags(rules: &Rules, counts: &[TypeCount]) -> u16 {
    counts
        .iter()
        .map(|(color, count)| *count * count_bags(rules, &rules[color]))
        .sum::<u16>()
        + 1 // For the current bag.
}
