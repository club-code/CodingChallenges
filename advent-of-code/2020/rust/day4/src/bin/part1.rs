use anyhow::Result;
use day4::parse_passport;

fn main() -> Result<()> {
    let mut valid = 0;

    loop {
        let pass = parse_passport()?;

        if pass.is_empty() {
            break;
        } else {
            valid += (pass.len() == 8 || pass.len() == 7 && !pass.contains("cid")) as u16;
        }
    }

    println!("{}", valid);
    Ok(())
}
