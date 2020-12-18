use std::collections::HashSet;
use std::io;

use anyhow::Result;

pub fn parse_next_group() -> Result<Vec<HashSet<char>>> {
    let mut group = Vec::new();

    while let Some(person) = parse_next_person()? {
        group.push(person);
    }

    Ok(group)
}

fn parse_next_person() -> Result<Option<HashSet<char>>> {
    let mut line = String::new();
    Ok(if io::stdin().read_line(&mut line)? == 0 || line == "\n" {
        None
    } else {
        Some(line.trim_end().chars().collect())
    })
}
