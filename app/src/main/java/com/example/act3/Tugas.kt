package com.example.act3

import androidx.annotation.DimenRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.core.content.res.ResourcesCompat

@Composable
fun ukuranFont(@DimenRes id: Int): TextUnit =
    with(LocalDensity.current) { dimensionResource(id).toSp() }

@Composable
fun KartuProfil(
    warnaCard: Int,
    nama: Int,
    alamat: Int,
    telepon: Int? = null,
    pakaiCursive: Boolean = false,
    warnaAlamat: Int = R.color.yellow
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_card),
                vertical = dimensionResource(R.dimen.padding_card_vertikal)
            ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(warnaCard)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.logo_umy),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.ukuran_logo))
                    .padding(all = dimensionResource(R.dimen.padding_logo))
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.jarak_logo_teks)))

            Column(
                modifier = Modifier.weight(
                    ResourcesCompat.getFloat(
                        LocalContext.current.resources,
                        R.dimen.bobot_teks
                    )
                )
            ) {
                Text(
                    text = stringResource(nama),
                    fontSize = if (pakaiCursive) ukuranFont(R.dimen.font_nama_cursive)
                    else ukuranFont(R.dimen.font_nama),
                    fontFamily = if (pakaiCursive) FontFamily.Cursive else FontFamily.Default,
                    fontWeight = if (pakaiCursive) FontWeight.Normal else FontWeight.Bold,
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_nama))
                )
                if (telepon != null) {
                    Text(
                        text = stringResource(telepon),
                        fontSize = ukuranFont(R.dimen.font_telp),
                        color = colorResource(R.color.cyan),
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_telp))
                    )
                }
                Text(
                    text = stringResource(alamat),
                    fontSize = ukuranFont(R.dimen.font_alamat),
                    color = colorResource(warnaAlamat),
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_alamat))
                )
            }

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.jarak_logo_teks)))
            Image(
                painter = painterResource(R.drawable.logo_umy),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.ukuran_logo))
                    .padding(all = dimensionResource(R.dimen.padding_logo))
            )
        }
    }
}

@Composable
fun HalamanUtama(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(top = dimensionResource(R.dimen.padding_atas))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = R.string.prodi),
            fontSize = ukuranFont(R.dimen.font_prodi),
            fontWeight = FontWeight.Bold
        )
        Text(
            stringResource(id = R.string.univ),
            fontSize = ukuranFont(R.dimen.font_univ),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_judul)))

        KartuProfil(
            warnaCard = R.color.card_0_bg,
            nama = R.string.nama_0,
            alamat = R.string.alamat_0,
            pakaiCursive = true
        )
        KartuProfil(
            warnaCard = R.color.card_1_bg,
            nama = R.string.nama_1,
            telepon = R.string.telp_1,
            alamat = R.string.alamat_1
        )
        KartuProfil(
            warnaCard = R.color.card_2_bg,
            nama = R.string.nama_2,
            telepon = R.string.telp_2,
            alamat = R.string.alamat_2,
            warnaAlamat = R.color.white
        )
        KartuProfil(
            warnaCard = R.color.card_3_bg,
            nama = R.string.nama_3,
            telepon = R.string.telp_3,
            alamat = R.string.alamat_3,
            warnaAlamat = R.color.white
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                stringResource(R.string.copy),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = dimensionResource(R.dimen.padding_bawah_copy))
            )
        }
    }
}