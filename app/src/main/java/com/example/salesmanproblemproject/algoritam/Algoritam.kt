package com.example.salesmanproblemproject.algoritam

import com.example.salesmanproblemproject.database.GradDB

import kotlin.Double.Companion.MAX_VALUE

class Algoritam(var lista: List<GradDB>) {



    fun najkraciPut(): MutableList<GradDB> {
        var pomocna = lista.toMutableList()
        var pocetniGrad = lista[0]
        pomocna.removeFirst()
        var permutacije = permutacije(pomocna)
        var minimalanPut = MAX_VALUE
        var rezultat = mutableListOf<GradDB>()
        for(i in 0..permutacije.size-1) {
            var trenutniPut = udaljenost(pocetniGrad.latituda,pocetniGrad.longituda,permutacije[i][0].latituda,
            permutacije[i][0].longituda)
            for(j in 0..permutacije[i].size-2) {
                trenutniPut += udaljenost(permutacije[i][j].latituda,permutacije[i][j].longituda,
                permutacije[i][j+1].latituda,permutacije[i][j+1].longituda)
            }
            trenutniPut += udaljenost(permutacije[i][permutacije[i].size-1].latituda,
                permutacije[i][permutacije[i].size-1].longituda,pocetniGrad.latituda,pocetniGrad.longituda)

            if(trenutniPut < minimalanPut) {
                minimalanPut = trenutniPut
                var pomocna = permutacije[i]
                pomocna.add(0,pocetniGrad)
                rezultat = pomocna
            }

        }

        return rezultat
    }


    private fun permutacije(lista : MutableList<GradDB>):MutableList<MutableList<GradDB>> {
        var rezultat = mutableListOf<MutableList<GradDB>>()
        if (lista.size == 1) {
            var listaPomocna: MutableList<MutableList<GradDB>> = mutableListOf(mutableListOf(lista[0]))
            return listaPomocna
        }

        for(i in 0..lista.size-1) {
            var prvi = lista.removeFirst()
            var perm = permutacije(lista)

            for(j in 0..perm.size-1)
                perm[j].add(prvi)

            rezultat = rezultat.plus(perm).toMutableList()/*Provjerit da li merga dobro*/
            lista.add(prvi)
        }
        return rezultat
    }

    fun udaljenost(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta))
        dist = Math.acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344
        return dist
    }

    private fun deg2rad(deg: Double): Double {
        return deg * Math.PI / 180.0
    }

    private fun rad2deg(rad: Double): Double {
        return rad * 180.0 / Math.PI
    }
}