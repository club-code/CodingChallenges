use anyhow::Result;
use day6::parse_next_group;

fn main() -> Result<()> {
    let mut sum = 0;

    loop {
        let group = parse_next_group()?;

        if group.is_empty() {
            break;
        } else {
            sum += group.len();
        }
    }

    println!("{}", sum);
    Ok(())
}
