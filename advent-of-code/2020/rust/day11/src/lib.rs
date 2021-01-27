use anyhow::Result;
use std::io::{self, BufRead};

// Types of seat states.
pub const EMPTY_CHAR: char = 'L';
pub const OCCPD_CHAR: char = '#';
pub const FLOOR_CHAR: char = '.';

/// Shortcut for the grid type.
pub type Layout = Vec<Vec<char>>;

/// Parses the standard input into a grid of characters.
pub fn parse_layout() -> Result<Layout> {
    io::stdin()
        .lock()
        .lines()
        .map(|line| Ok(line?.chars().collect()))
        .collect()
}

/// Counts the total number of occupied seats in the entire layout.
pub fn count_occpd_seats(lyt: &Layout) -> usize {
    lyt.iter()
        .map(|line| line.iter().filter(|&&chr| chr == OCCPD_CHAR).count())
        .sum()
}

/// Determines the state in which the given seat should be in for the next
/// round, with the number of `occpd_neighs` and counting `tolerance`.
pub fn next_seat_state(seat_state: char, occpd_neighs: u8, tolerance: u8) -> char {
    if seat_state == EMPTY_CHAR && occpd_neighs == 0 {
        OCCPD_CHAR
    } else if seat_state == OCCPD_CHAR && occpd_neighs >= tolerance {
        EMPTY_CHAR
    } else {
        seat_state
    }
}

/// Executes an entire automaton round from the given layout, "neighbor"
/// counting function and counting tolerance and returns the new layout.
///
/// The `count_fn` should accept a reference to a layout and a grid position's
/// indices in order to return a form of occupied seats count that will be used
/// to update the seat's state at the given position. See part 1 and 2.
pub fn run_round(lyt: &Layout, count_fn: fn(&Layout, usize, usize) -> u8, tolerance: u8) -> Layout {
    // Clone instead of iterator collect for faster memory operations.
    let mut next = lyt.clone();

    for i in 0..lyt.len() {
        for j in 0..lyt[0].len() {
            next[i][j] = next_seat_state(lyt[i][j], count_fn(lyt, i, j), tolerance);
        }
    }

    next
}

/// Runs the automaton for as many rounds as needed in order to reach the
/// stable state and returns the count of occupied seats in the final layout,
/// with the same arguments as for `run_round`.
pub fn find_stability_count(
    mut lyt: Layout,
    count_fn: fn(&Layout, usize, usize) -> u8,
    tolerance: u8,
) -> usize {
    let mut next = run_round(&lyt, count_fn, tolerance);

    while next != lyt {
        lyt = next;
        next = run_round(&lyt, count_fn, tolerance);
    }

    count_occpd_seats(&next)
}
