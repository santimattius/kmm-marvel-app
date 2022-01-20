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
        AsyncImage(url: URL(string: character.thumbnail), transaction: Transaction(animation: .easeIn)) { phase in
            switch phase {
            case .empty:
                ZStack{
                    Color.gray.opacity(0.1)
                    ProgressView()
                }
            case .success(let image):
                image
                    .resizable()
                    .aspectRatio(0.67, contentMode: .fit)

            case .failure(_):
                Image(systemName: "exclamationmark.icloud")
                    .resizable()
                    .scaledToFit()

            @unknown default:
                Image(systemName: "exclamationmark.icloud")
            }
        }
        .frame(
            minWidth: 100,
            maxWidth: .infinity,
            minHeight: 200
        )
        .aspectRatio(0.67, contentMode: .fill)
        .cornerRadius(4)
    }
}

struct CharacterItemView_Previews: PreviewProvider {
    static var previews: some View {
        CharacterItemView(
            character: UiCharacter(
                id: 1,
                name: "Prueba",
                thumbnail: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg",
                description: "This is description"
            )
        )
    }
}
