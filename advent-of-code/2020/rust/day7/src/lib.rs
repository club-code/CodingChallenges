use std::collections::HashMap;
use std::io::{self, BufRead};

use anyhow::Result;

pub type BagType = String;
pub type TypeCount = (BagType, u16);
pub type Rules = HashMap<BagType, Vec<TypeCount>>;

pub fn parse_rules() -> Result<Rules> {
    let mut rules = HashMap::new();

    for line in io::stdin().lock().lines() {
        let split = line?
            .split(" bags contain ")
            .map(|s| s.to_owned())
            .collect::<Vec<_>>();
        rules.insert(
            split[0].clone(),
            split[1]
                .split(", ")
                .take_while(|ct| !ct.starts_with("no"))
                .map(|ct| {
                    let parts = ct
                        .split_whitespace()
                        .map(|s| s.to_owned())
                        .collect::<Vec<_>>();
                    (
                        parts[1].clone() + " " + &parts[2],
                        parts[0].parse().unwrap(),
                    )
                })
                .collect::<Vec<_>>(),
        );
    }

    Ok(rules)
}
