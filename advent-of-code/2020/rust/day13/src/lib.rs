use anyhow::{anyhow, Result};
use std::io::{self, BufRead};

pub type Value = i64;

pub struct Notes {
    pub timestamp: Value,
    pub buses: Vec<(Value, Value)>,
}

pub fn parse_notes() -> Result<Notes> {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    Ok(Notes {
        timestamp: lines
            .next()
            .transpose()?
            .ok_or_else(|| anyhow!("Not enough lines"))?
            .parse()?,
        buses: lines
            .next()
            .transpose()?
            .ok_or_else(|| anyhow!("Not enough lines"))?
            .split(',')
            .enumerate()
            .filter(|&(_, id_str)| id_str != "x")
            .map(|(i, id_str)| Ok((i as Value, id_str.parse()?)))
            .collect::<Result<Vec<_>>>()?,
    })
}
