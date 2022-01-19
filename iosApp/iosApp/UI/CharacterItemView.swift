//
//  CharacterItemView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 4/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct CharacterItemView: View {
    
    var character: UiCharacter
    
    var body: some View {
        AsyncImage(url: URL(string: character.thumbnail)) { image in
               image
                   .resizable()
                   .aspectRatio(0.67, contentMode: .fit)
                   .frame(minWidth: 0,
                          maxWidth: .infinity,
                          minHeight: 50)
                   .cornerRadius(4)
           } placeholder: {
               ProgressView()
           }
    }
}

struct CharacterItemView_Previews: PreviewProvider {
    static var previews: some View {
        CharacterItemView(character: UiCharacter(name: "Prueba", thumbnail: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg", description: "This is description"))
    }
}
