use std::collections::HashSet;
use std::io;

use anyhow::Result;

pub fn parse_passport() -> Result<HashSet<String>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut set = HashSet::new();

    while stdin.read_line(&mut line)? != 0 && !line.trim_end().is_empty() {
        set.extend(
            line.split_whitespace()
                .map(|couple| couple.split(':').next().unwrap().to_owned()),
        );
        line.clear();
    }

    Ok(set)
}
