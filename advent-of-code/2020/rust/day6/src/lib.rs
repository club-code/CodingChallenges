use std::collections::HashSet;
use std::io;

use anyhow::Result;

/// Parses the next group of people from the standard input.
pub fn parse_next_group() -> Result<Vec<HashSet<char>>> {
    let mut group = Vec::new();

    while let Some(person) = parse_next_person()? {
        group.push(person);
    }

    Ok(group)
}

/// Parses the next line available on the standard input stream into a set of
/// its answers given, `None` if the group or stream endend otherwise.
fn parse_next_person() -> Result<Option<HashSet<char>>> {
    let mut line = String::new();
    Ok(if io::stdin().read_line(&mut line)? == 0 || line == "\n" {
        None
    } else {
        Some(line.trim_end().chars().collect())
    })
}
