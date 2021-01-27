use anyhow::Result;
use std::io::{self, BufRead};

pub const EMPTY_CHAR: char = 'L';
pub const OCCPD_CHAR: char = '#';
pub const FLOOR_CHAR: char = '.';

pub type Layout = Vec<Vec<char>>;

pub fn parse_layout() -> Result<Layout> {
    io::stdin()
        .lock()
        .lines()
        .map(|line| Ok(line?.chars().collect()))
        .collect()
}

pub fn count_occpd_seats(lyt: &Layout) -> usize {
    lyt.iter()
        .map(|line| line.iter().filter(|&&chr| chr == OCCPD_CHAR).count())
        .sum()
}

pub fn next_seat_state(seat_state: char, occpd_neighs: u8, tolerance: u8) -> char {
    if seat_state == EMPTY_CHAR && occpd_neighs == 0 {
        OCCPD_CHAR
    } else if seat_state == OCCPD_CHAR && occpd_neighs >= tolerance {
        EMPTY_CHAR
    } else {
        seat_state
    }
}

pub fn run_round(lyt: &Layout, count_fn: fn(&Layout, usize, usize) -> u8, tolerance: u8) -> Layout {
    let mut next = lyt.clone();

    for i in 0..lyt.len() {
        for j in 0..lyt[0].len() {
            next[i][j] = next_seat_state(lyt[i][j], count_fn(lyt, i, j), tolerance);
        }
    }

    next
}

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
