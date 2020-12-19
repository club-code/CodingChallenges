use anyhow::Result;
use day7::{parse_rules, Rules, TypeCount};

fn main() -> Result<()> {
    let rules = parse_rules()?;
    println!(
        "{}",
        rules
            .values()
            .filter(|counts| contains_gold(&rules, counts))
            .count()
    );
    Ok(())
}

fn contains_gold(rules: &Rules, counts: &[TypeCount]) -> bool {
    counts
        .iter()
        .any(|(color, _)| color == "shiny gold" || contains_gold(rules, &rules[color]))
}
