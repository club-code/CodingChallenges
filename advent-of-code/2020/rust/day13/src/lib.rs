use anyhow::{anyhow, Result};
use std::io::{self, BufRead};

pub struct Notes {
    pub timestamp: u32,
    pub buses: Vec<u32>,
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
            .filter(|&id_str| id_str != "x")
            .map(|id_str| Ok(id_str.parse()?))
            .collect::<Result<Vec<_>>>()?,
    })
}
