use anyhow::Result;
use day7::{parse_rules, Rules, TypeCount};

/// Solves part 1 by counting the bags containing gold.
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

/// Returns `true` iff `counts` directly or indirectly contains a "shiny gold"
/// colored bag following the given `rules`. Operates recursively.
fn contains_gold(rules: &Rules, counts: &[TypeCount]) -> bool {
    counts
        .iter()
        .any(|(color, _)| color == "shiny gold" || contains_gold(rules, &rules[color]))
}
