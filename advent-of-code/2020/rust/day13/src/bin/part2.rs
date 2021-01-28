use anyhow::Result;
use modinverse::modinverse;

use day13::*;

fn main() -> Result<()> {
    let buses = parse_notes()?.buses;
    let id_prod = buses.iter().map(|&(_, id)| id).product();

    println!(
        "{}",
        buses
            .into_iter()
            .map(|(i, id)| {
                let wo_id = id_prod / id;
                i * wo_id * modinverse(wo_id, id).unwrap()
            })
            .sum::<Value>()
            .saturating_neg()
            .rem_euclid(id_prod)
    );
    Ok(())
}
