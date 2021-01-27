use anyhow::Result;
use day11::*;

/// Solves part 1 by running the automaton until stability with part 1 parameters.
fn main() -> Result<()> {
    println!(
        "{}",
        find_stability_count(parse_layout()?, count_occpd_neighs, 4)
    );
    Ok(())
}

/// Counts the number of adjacent seats of the given `(i, j)` position of `lyt`
/// that are currently occupied.
fn count_occpd_neighs(lyt: &Layout, i: usize, j: usize) -> u8 {
    // Iterators only, no additional memory allocation.
    (i.saturating_sub(1)..=i + 1)
        .filter_map(|ni| lyt.get(ni))
        .flat_map(|line| (j.saturating_sub(1)..=j + 1).filter_map(move |nj| line.get(nj)))
        .filter(|&&chr| chr == OCCPD_CHAR)
        .count()
        .saturating_sub((lyt[i][j] == OCCPD_CHAR) as usize) as u8
}
