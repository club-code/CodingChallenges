use anyhow::Result;
use std::io;

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

#[derive(Debug)]
pub struct BoardPass {
    row: u8,
    col: u8,
}

impl BoardPass {
    pub fn id(&self) -> u16 {
        8 * self.row as u16 + self.col as u16
    }

    fn from_steps(steps: &[BinStep]) -> Self {
        Self {
            row: Self::follow_steps(&steps[..6], 127),
            col: Self::follow_steps(&steps[7..], 7),
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

        start + 1
    }
}

pub fn parse_passes() -> Result<Vec<BoardPass>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut passes = Vec::new();

    while stdin.read_line(&mut line)? != 0 {
        passes.push(BoardPass::from_steps(
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
