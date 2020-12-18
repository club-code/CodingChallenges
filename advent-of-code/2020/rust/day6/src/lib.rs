use std::collections::HashSet;
use std::io;

use anyhow::Result;

pub fn parse_next_group() -> Result<HashSet<char>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut group = HashSet::new();

    while stdin.read_line(&mut line)? != 0 && line != "\n" {
        group.extend(line.trim_end().chars());
        line.clear();
    }

    Ok(group)
}
