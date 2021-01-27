use anyhow::Result;
use day11::*;

fn main() -> Result<()> {
    let mut lyt = parse_layout()?;
    let mut next = run_round(&lyt);

    while next != lyt {
        lyt = next;
        next = run_round(&lyt);
    }

    println!("{}", count_occpd_seats(&next));
    Ok(())
}

fn run_round(lyt: &Layout) -> Layout {
    let mut next = lyt.clone();

    for i in 0..lyt.len() {
        for j in 0..lyt[0].len() {
            next[i][j] = next_seat_state(lyt[i][j], count_occpd_neighs(lyt, i, j));
        }
    }

    next
}

fn next_seat_state(seat_state: char, occpd_neighs: u8) -> char {
    if seat_state == EMPTY_CHAR && occpd_neighs == 0 {
        OCCPD_CHAR
    } else if seat_state == OCCPD_CHAR && occpd_neighs >= 4 {
        EMPTY_CHAR
    } else {
        seat_state
    }
}

fn count_occpd_neighs(lyt: &Layout, i: usize, j: usize) -> u8 {
    (i.saturating_sub(1)..=i + 1)
        .filter_map(|ni| lyt.get(ni))
        .flat_map(|line| (j.saturating_sub(1)..=j + 1).filter_map(move |nj| line.get(nj)))
        .filter(|&&chr| chr == OCCPD_CHAR)
        .count()
        .saturating_sub((lyt[i][j] == OCCPD_CHAR) as usize) as u8
}

fn count_occpd_seats(lyt: &Layout) -> usize {
    lyt.iter()
        .map(|line| line.iter().filter(|&&chr| chr == OCCPD_CHAR).count())
        .sum()
}
