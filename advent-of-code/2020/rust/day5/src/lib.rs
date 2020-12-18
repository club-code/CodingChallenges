use std::collections::HashSet;
use std::io;

use anyhow::Result;

// Dimensions.
pub const ROWS: u8 = 128;
pub const COLS: u8 = 8;

/// Represents the first or second half of an interval.
#[derive(Debug)]
enum BinStep {
    Start,
    End,
}

/// Federates input characters to dichotomy steps.
impl From<char> for BinStep {
    fn from(value: char) -> Self {
        match value {
            'F' | 'L' => Self::Start,
            'B' | 'R' => Self::End,
            _ => panic!("Unknown step: '{}'", value),
        }
    }
}

/// Represents a boarding pass with its identifying information split.
#[derive(Debug, Clone, Hash, PartialEq, Eq)]
pub struct BoardPass {
    pub row: u8,
    pub col: u8,
}

impl BoardPass {
    /// Computes and returns the boarding pass ID.
    pub fn id(&self) -> u16 {
        COLS as u16 * self.row as u16 + self.col as u16
    }

    /// Returns the pass for the seat `places` to the right of the current seat
    /// by using the ID in order to take row jumps into account.
    pub fn next(&self, places: u8) -> Self {
        Self::from_id(self.id() + places as u16)
    }

    /// Returns the pass for the seat `places` to the left of the current seat
    /// by using the ID in order to take row jumps into account.
    pub fn prev(&self, places: u8) -> Self {
        Self::from_id(self.id() - places as u16)
    }

    /// Builds a pass from an ID.
    fn from_id(id: u16) -> Self {
        Self {
            row: (id / COLS as u16) as u8,
            col: (id % COLS as u16) as u8,
        }
    }

    /// Builds a pass from a series of dichotomy `steps`.
    fn from_steps(steps: &[BinStep]) -> Self {
        Self {
            row: Self::follow_steps(&steps[..7], ROWS),
            col: Self::follow_steps(&steps[7..], COLS),
        }
    }

    /// Returns the number identified by the dichotomy `steps` with at most `max`.
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

/// Reads the lines from the standard input into a set of boarding passes.
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
