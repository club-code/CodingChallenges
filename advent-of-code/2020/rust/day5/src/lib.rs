use std::collections::HashSet;
use std::io;

use anyhow::Result;

pub const ROWS: u8 = 128;
pub const COLS: u8 = 8;

#[derive(Debug)]
enum BinStep {
    Start,
    End,
}

impl From<char> for BinStep {
    fn from(value: char) -> Self {
        match value {
            'F' | 'L' => Self::Start,
            'B' | 'R' => Self::End,
            _ => panic!("Unknown step: '{}'", value),
        }
    }
}

#[derive(Debug, Clone, Hash, PartialEq, Eq)]
pub struct BoardPass {
    pub row: u8,
    pub col: u8,
}

impl BoardPass {
    pub fn id(&self) -> u16 {
        COLS as u16 * self.row as u16 + self.col as u16
    }

    pub fn next(&self, places: u8) -> Self {
        Self::from_id(self.id() + places as u16)
    }

    pub fn prev(&self, places: u8) -> Self {
        Self::from_id(self.id() - places as u16)
    }

    fn from_id(id: u16) -> Self {
        Self {
            row: (id / COLS as u16) as u8,
            col: (id % COLS as u16) as u8,
        }
    }

    fn from_steps(steps: &[BinStep]) -> Self {
        Self {
            row: Self::follow_steps(&steps[..7], ROWS),
            col: Self::follow_steps(&steps[7..], COLS),
        }
    }

    fn follow_steps(steps: &[BinStep], max: u8) -> u8 {
        let mut start = 0;
        let mut end = max;

        for step in steps {
            let middle = (start + end) / 2;

            match step {
                BinStep::Start => end = middle,
                BinStep::End => start = middle,
            }
        }

        start
    }
}

pub fn parse_passes() -> Result<HashSet<BoardPass>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut passes = HashSet::new();

    while stdin.read_line(&mut line)? != 0 {
        passes.insert(BoardPass::from_steps(
            &line
                .trim_end()
                .chars()
                .map(BinStep::from)
                .collect::<Vec<_>>(),
        ));
        line.clear();
    }

    Ok(passes)
}
