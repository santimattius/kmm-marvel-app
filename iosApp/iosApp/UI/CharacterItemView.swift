//
//  CharacterItemView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 4/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct CharacterItemView: View {
    
    var character: Character
    
    var body: some View {
        VStack(alignment:.center) {
            AsyncImage(url: URL(string: character.thumbnail)) { image in
                   image
                       .resizable()
                       .aspectRatio(0.67, contentMode: .fit)
                       .overlay{
                           Rectangle()
                               .scaledToFill()
                               .foregroundColor(.gray)
                               .opacity(0.5)
                               .overlay(
                                   VStack(alignment:.center) {
                                       Spacer()
                                       Text(character.name)
                                           .fontWeight(.bold)
                                           .font(.title)
                                           .foregroundColor(.white)
                                           .lineSpacing(8)
                                           .padding()
                                   }
                               )
                       }
               } placeholder: {
                   ProgressView()
               }
           }
           .frame(minWidth: 300)
           .cornerRadius(4)
    }
}

struct CharacterItemView_Previews: PreviewProvider {
    static var previews: some View {
        CharacterItemView(character: Character(name: "Prueba", thumbnail: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg", description: "This is description"))
    }
}
