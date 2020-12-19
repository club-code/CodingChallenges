use anyhow::Result;
use day7::{parse_rules, Rules, TypeCount};

fn main() -> Result<()> {
    let rules = parse_rules()?;
    println!("{}", count_bags(&rules, &rules["shiny gold"]) - 1);
    Ok(())
}

fn count_bags(rules: &Rules, counts: &[TypeCount]) -> u16 {
    counts
        .iter()
        .map(|(color, count)| *count * count_bags(rules, &rules[color]))
        .sum::<u16>()
        + 1
}
