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
