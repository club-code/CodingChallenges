use anyhow::Result;
use day11::*;

/// Solves part 2 by running the automaton until stability with part 2 parameters.
fn main() -> Result<()> {
    println!(
        "{}",
        find_stability_count(parse_layout()?, count_occpd_star, 5)
    );
    Ok(())
}

/// Counts the number of seats in the eight-branch star-shaped vicinity of the
/// given `(i, j)` position of `lyt`, with only first encounters taken.
fn count_occpd_star(lyt: &Layout, i: usize, j: usize) -> u8 {
    let mut count = 0;

    // Direction vectors.
    for dir in [
        (-1, -1),
        (-1, 0),
        (-1, 1),
        (0, -1),
        (0, 1),
        (1, -1),
        (1, 0),
        (1, 1),
    ]
    .iter()
    {
        let mut di = dir.0 + i as isize;
        let mut dj = dir.1 + j as isize;

        // Propagate the search along the projected direction.
        while 0 <= di && di < lyt.len() as isize && 0 <= dj && dj < lyt[0].len() as isize {
            match lyt[di as usize][dj as usize] {
                OCCPD_CHAR => {
                    count += 1;
                    break;
                }
                EMPTY_CHAR => break,
                _ => {
                    di += dir.0;
                    dj += dir.1;
                }
            }
        }
    }

    count
}
