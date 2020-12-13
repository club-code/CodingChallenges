use anyhow::Result;
use std::io;

pub fn parse_numbers() -> Result<Vec<u32>> {
    let stdin = io::stdin();
    let mut lines = Vec::new();

    loop {
        let mut line = String::new();

        if stdin.read_line(&mut line)? == 0 {
            break;
        } else {
            lines.push(line.trim_end().parse()?);
        }
    }

    Ok(lines)
}
