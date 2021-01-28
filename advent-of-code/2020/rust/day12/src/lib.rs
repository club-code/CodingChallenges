use std::io::{self, BufRead};
use std::str::FromStr;

use anyhow::{anyhow, Error, Result};

pub type Value = i16;

#[derive(Debug, Clone)]
pub enum Action {
    North(Value),
    South(Value),
    East(Value),
    West(Value),
    Left(Value),
    Right(Value),
    Forward(Value),
}

impl FromStr for Action {
    type Err = Error;

    fn from_str(ins: &str) -> Result<Self> {
        if ins.len() < 2 {
            Err(anyhow!("String too short"))
        } else {
            let value = ins[1..].parse::<Value>()?;
            Ok(match ins.chars().next().unwrap() {
                'N' => Action::North(value),
                'S' => Action::South(value),
                'E' => Action::East(value),
                'W' => Action::West(value),
                'L' => Action::Left(value),
                'R' => Action::Right(value),
                'F' => Action::Forward(value),
                action => return Err(anyhow!("Unknown action '{}'", action)),
            })
        }
    }
}

pub fn parse_action() -> Result<Option<Action>> {
    io::stdin()
        .lock()
        .lines()
        .next()
        .map(|line| line?.parse())
        .transpose()
}
