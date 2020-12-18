#![feature(iterator_fold_self)]

use anyhow::Result;
use day6::parse_next_group;

/// Solves part 1 by computing the intersections of groups people's answers
/// and then summing all their respective lengths together.
fn main() -> Result<()> {
    let mut sum = 0;

    loop {
        let group = parse_next_group()?;

        if group.is_empty() {
            break;
        } else {
            sum += group
                .into_iter()
                .fold_first(|elt, acc| &acc & &elt)
                .unwrap()
                .len();
        }
    }

    println!("{}", sum);
    Ok(())
}
